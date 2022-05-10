package test

import (
	"testing"

	"github.com/gruntwork-io/terratest/modules/docker"
)

func composeUp(t *testing.T, workingDir string, envVars map[string]string) string {
	opts := &docker.Options{
		WorkingDir: workingDir,

		EnvVars: envVars,
	}

	docker.RunDockerCompose(t, opts, "up", "-d")
	return ""
}

func composeDown(t *testing.T, workingDir string) {
	opts := &docker.Options{
		WorkingDir: workingDir,
	}
	defer docker.RunDockerCompose(t, opts, "down")
}

// func verify(t *testing.T, url string, body_w string) {
// 	retries := 10
// 	sleep := 3 * time.Second
// 	http_helper.HttpGetWithRetryWithCustomValidation(
// 		t,
// 		url,
// 		nil,
// 		retries,
// 		sleep,
// 		func(statusCode int, body string) bool {
// 			isOk := statusCode == 200
// 			isBackEnd := assert.Contains(t, body, body_w)
// 			return isOk && isBackEnd
// 		},
// 	)
// }

// func TestApp(t *testing.T) {
// 	t.Parallel()
// 	const workingDir = "./python"
// 	envVars := map[string]string{
// 		"JWT_SECRET":          "teachuamain",
// 		"DATASOURCE_URL":      "jdbc:postgresql://postgres:5432/postgres",
// 		"DATASOURCE_USER":     "root",
// 		"DATASOURCE_PASSWORD": "root",
// 	}

// 	defer composeDown(t, workingDir)
// 	composeUp(t, workingDir, envVars)

// 	verify(t, "http://localhost:8000", "Hello")
// }
