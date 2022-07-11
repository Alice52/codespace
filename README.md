## build codespace for languages

### java 10

### python 11

1. with docker-compose
2. if image not os, please hangup container for running service

   ```yml
   services:
     app:
       command: /bin/sh -c "while sleep 1000; do :; done"
   ```

3. make inside docker used host docker

   - devcontainer.json

     ```json
     "features": {
         "docker-from-docker": "20.10"
     }
     ```

   - docker-compose.yml

     ```yml
     services:
       app:
         volumes:
           - /var/run/docker.sock:/var/run/docker.sock
     ```
