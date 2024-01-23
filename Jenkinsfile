node{
  stage('SCM Checkout'){
    git 'https://github.com/vjamdade1/gd19.01.2024'
  }
  stage('Compile-Package'){
    sh 'mvn package'
  }
}
