
def call(String deploymentName, String namespace) {
    echo "Verifying Kubernetes deployment: ${deploymentName}"

    sh """
        kubectl rollout status deployment/${deploymentName} \
            -n ${namespace} --timeout=120s

        echo "===== PODS ====="
        kubectl get pods -n ${namespace}

        echo "===== DEPLOYMENT ====="
        kubectl get deployment ${deploymentName} -n ${namespace}

        echo "===== SERVICES ====="
        kubectl get services -n ${namespace}
    """
}

