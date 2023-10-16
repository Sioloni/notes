pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                script {
                    def branchName = env.BRANCH_NAME ?: 'unknown'
                    def inventory_file = 'build-app/inventory.ini'
                    def job_path = currentBuild.fullDisplayName.split(" » ")[-2]
                    def job_name = job_path.split("/")[-1]
                    switch (branchName) {
                        case 'production':
                            deploy = 'build-app/deploy.yml'
                            break
                    }
                    withCredentials([string(credentialsId: 'maven_publish_username', variable: 'MAVEN_PUBLISH_USERNAME'),
                                     string(credentialsId: 'maven_publish_password', variable: 'MAVEN_PUBLISH_PASSWORD')]) {
                        ansiblePlaybook(
                                playbook: "${deploy}",
                                inventory: "${inventory_file}",
                                credentialsId: 'ansible_key',
                                extraVars: [branch: env.BRANCH_NAME,
                                            git_name: "${job_name}",
                                            git_path: "${job_path}",
                                            maven_publish_username: "${MAVEN_PUBLISH_USERNAME}",
                                            maven_publish_password: "${MAVEN_PUBLISH_PASSWORD}"]

                        )
                    }
                }
            }
        }
    }
    post {
        always {
            script {
                withCredentials([string(credentialsId: 'bot_token', variable: 'TOKEN'),
                                 string(credentialsId: 'chat_id', variable: 'CHAT_ID'),
                                 string(credentialsId: 'message_thread_id', variable: 'MESSAGE_THREAD_ID')]) {
                    def status = currentBuild.currentResult.toString().toUpperCase()
                    def job_name = currentBuild.fullDisplayName.split(" » ")[-2]
                    def branchName = env.BRANCH_NAME
                    def check = "${branchName}_${status}"
                    switch (check) {
                        case 'production_SUCCESS':
                            message = "<b>${job_name}</b>\n<b>Branch</b>: ${env.GIT_BRANCH}\n<b>Number</b>: ${env.BUILD_NUMBER}\n<b>Build</b>: ${status}\n${env.BUILD_URL}console"
                            break
                        default:
                            message = "<b>${job_name}</b>\n<b>Branch</b>: ${env.GIT_BRANCH}\n<b>Number</b>: ${env.BUILD_NUMBER}\n<b>Build</b>: ${status}\n${env.BUILD_URL}console"
                            break
                    }
                sh ("""
                curl -s -X POST https://api.telegram.org/bot${TOKEN}/sendMessage \
                -d chat_id=${CHAT_ID} \
                -d parse_mode=HTML \
                -d text="${message}" \
                -d message_thread_id=${MESSAGE_THREAD_ID}
            """)
                }
            }
        }
    }

}