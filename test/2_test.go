package test

import (
	"testing"

	"github.com/gruntwork-io/terratest/modules/docker"
	"github.com/stretchr/testify/assert"
)

func TestDocker(t *testing.T) {
	tag := "gruntwork/docker-hello-world-example"
	buildOptions := &docker.BuildOptions{
		Tags: []string{tag},
	}

	docker.Build(t, "./python", buildOptions)

	opts := &docker.RunOptions{Command: []string{"echo", "Hello, World!"}}
	output := docker.Run(t, tag, opts)
	assert.Equal(t, "Hello, World!", output)
}
