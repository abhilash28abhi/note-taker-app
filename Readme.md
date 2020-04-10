Spring boot based note taking app using mongo db for storage.
It uses apache freemarker as a template engine for html pages.

Run the following commands to build the docker image and run the containers:<br/>
1.  To build the image from the current directory <br/>
    `docker image build -t note-taker-app:1.0 .`
2.  Build a network so that we can have communication between the java and mongo containers:<br/>
    `docker create mynote-network`
3.  `docker container run --name mymongo --network mynote-network -d mongo`
4.  We can use the name of mongo container as hostname for mongo db url since they are on the same network now<br/>
    `docker run --name mynote-app -d -p 8080:8080 --network mynote-network -e MONGO_URL=mongodb://mymongo:27017/dev note-taker-app:1.0`<br/>
5.  `docker container exec -it mynote-app sh`<br/>
    To check the images being uploaded to the mynote-app container and navigate to /tmp/uploads
6.  To run the image pushed to docker hub directly use below command for the note app: <br/>
    `docker container run -d -p 8080:8080 --name mynote --network mynote-network -e MONGO_URL=mongodb://mymongo:27017/dev abhilash28abhi/note-taker-app:1.0`
7.  Additionally we can use docker compose file to bring up the containers using: <br/>
    `docker-compose --file docker-compose.yml config` - To check if the compose yml file is correct <br/>
    `docker-compose --file docker-compose.yml up -d` - To start the containers <br/>
    `docker-compose --file docker-compose.yml down` - To stop and remove the containers <br/>
8.  To run the k8's cluster, we need to deploy the files inside kube folder as below: <br/>
    `kubectl apply -f kube` : This command submits all the YAML files in the kube directory to Kubernetes<br/>
9.  We can view the application in this url with K8: `http://localhost:80`
10. To scale my note app deployment use : <br/>
    `kubectl scale --replicas=2 deployment/mynote`
    `kubectl delete deployment mymongo mynote` -- To delete the deployments and pods <br/>
    `kubectl delete services mymongo mynote` -- To delete the services <br/>
    `kubectl delete deployments --all` -- alternative command <br/>