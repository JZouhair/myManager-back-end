if  [[ $TRAVIS_BRANCH = 'master'  ||  ${TRAVIS_BRANCH} = 'develop' ]]; then
    echo 'Checking Quality Gates'
    mvn -B clean verify sonar:sonar -Dsonar.host.url=https://sonarcloud.io -Dsonar.projectKey=gestionEmploye  -Dsonar.organization=jzouhair-github -Dsonar.login=bbab126d09645aef6d2c21bf0b1f6efdb3ed6b1f;
fi
