Spring boot based note taking app using mongo db for storage.
It uses apache freemarker as a template engine for html pages.

Run the following commands to build the docker image and run the containers:<br/>
1.  `docker image build -t note-taker-app:1.0 .` - To build the image from the current directory <br/>
2.  Build a network so that we can have communication between the java and mongo containers:<br/>
    `docker create mynote-network`
3.  `docker container run --name mymongo --network mynote-network -d mongo`
4.  `docker run --name mynote-app -d -p 8080:8080 --network mynote-network -e MONGO_URL=mongodb://mymongo:27017/dev note-taker-app:1.0`
    We can use the name of mongo container as hostname for mongo db url since they are on the same network now<br/>
5.  `docker container exec -it mynote-app sh`
    To check the images being uploaded to the mynote-app container and navigate to /tmp/uploads
