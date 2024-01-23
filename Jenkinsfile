node{
  stage('SCM Checkout'){
 
    git 'https://github.com/vjamdade1/gd19.01.2024'
  }
  stage('Compile-Package'){
    //get maven home path
    def mvnHome= tool name: 'TestMaven', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
}

