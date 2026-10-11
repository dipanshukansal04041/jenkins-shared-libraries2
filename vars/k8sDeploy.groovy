
def call(String namespace, String manifestDir = '.') {
    echo "Deploying application to Kubernetes namespace: ${namespace}"

    sh """
        kubectl apply -f '${manifestDir}/namespace.yml'
        kubectl apply -f '${manifestDir}/deployment.yml' -n '${namespace}'
        kubectl apply -f '${manifestDir}/service.yml' -n '${namespace}'
    """
}

