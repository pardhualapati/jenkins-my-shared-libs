def trivy_fs(){
  sh "trivy -fs . -o results.json
}
