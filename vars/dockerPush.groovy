
def call(String imageName, String credentialId) {
    echo "Pushing Docker image: ${imageName}"

    withCredentials([
        usernamePassword(
            credentialsId: credentialId,
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )
    ]) {
        withEnv(["IMAGE_TO_PUSH=${imageName}"]) {
            sh '''
                set +x

                echo "$DOCKER_PASS" | docker login \
                    --username "$DOCKER_USER" \
                    --password-stdin

                docker push "$IMAGE_TO_PUSH"
                docker logout
            '''
        }
    }
}

