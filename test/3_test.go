package test

import (
	"fmt"
	"testing"
	"time"

	http_helper "github.com/gruntwork-io/terratest/modules/http-helper"
	"github.com/gruntwork-io/terratest/modules/k8s"
	"github.com/stretchr/testify/assert"
)

func verify(t *testing.T, url string, body_w string) {
	retries := 5
	sleep := 3 * time.Second
	http_helper.HttpGetWithRetryWithCustomValidation(
		t,
		url,
		nil,
		retries,
		sleep,
		func(statusCode int, body string) bool {
			isOk := statusCode == 200
			isBackEnd := assert.Contains(t, body, body_w)
			return isOk && isBackEnd
		},
	)
}

func TestKubernetesHelloWorldExample(t *testing.T) {
	t.Parallel()

	kubeResourcePath := "./vote/test.yaml"

	options := k8s.NewKubectlOptions("", "", "default")

	defer k8s.KubectlDelete(t, options, kubeResourcePath)

	k8s.KubectlApply(t, options, kubeResourcePath)

	k8s.WaitUntilServiceAvailable(t, options, "azure-vote-front", 10, 2*time.Second)
	service := k8s.GetService(t, options, "azure-vote-front")
	url := fmt.Sprintf("http://%s", k8s.GetServiceEndpoint(t, options, service, 80))

	verify(t, url, "Cats")
}
