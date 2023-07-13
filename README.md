# How to deploy on your own

Example Spring Boot app for deployment on capstone-project.de

## Running this on an existing EC2 instance

* Create yourself a docker hub account
  * https://hub.docker.com/signup
  * (optional) create token
    * https://hub.docker.com/settings/security
    * Click "New Access Token"
    * Give it a name, for example "github actions"
    * Select "Read, Write, Delete" for "Access permissions"
    * Click "Generate"
    * Copy the token (you will need it later)
* Define github secrets
  * `SSH_PASSWORD`: password for user `alpha`-`tango` on EC2 instance (a coach will provide this)
  * `DOCKERHUB_PASSWORD`: password for your docker hub account (if you created the optional token, use that instead)
* update `.github/workflows/deploy.yml` (search for all `#` comments)
* update `.github/workflows/show-logs.yml` (search for all `#` comments)
* make sure, that you set `finalName` to `app.jar` in your `pom.xml`
* Push code changes
* Github actions will deploy it to our shared EC2 instance

## Setting up a new EC2 instance (in your own AWS account)

1. Create EC2 instance on AWS
    * (keep default:) Amazon Linux 2023 AMI
    * (keep default:) t2.micro or similar is a good start for 1-5 spring boot apps
    * Add security group to allow inbound traffic for SSH, HTTP, HTTPS
2. Install docker
    * Connect to your EC2 instance (for example via AWS's web console)
    * Install docker
      * `sudo yum install docker --assumeyes --quiet`
      * `sudo service docker start`
    * Give our user permission to manage docker
      * `sudo usermod --append --groups docker ec2-user`
      * `newgrp docker`
    * optional: manually start docker container once
      * `docker run --pull=always --name myapp --publish 80:8080 --restart always --detach bartfastiel/deploy-to-aws-with-github-actions:latest`
    * then allow ssh password authentification
      * `sudo sed --in-place 's/PasswordAuthentication no/PasswordAuthentication yes/g' /etc/ssh/sshd_config`
3. Test
    * Open browser and go to EC2 instance public IP address (double check, that you use http:// and not https://)
