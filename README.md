# resteasy-template

<div>
<p>Notes:</p>   

I do not claim ownership to any techniques shown herein as there are many such examples of RestEasy on the web.
This project was created as a simple example of how to use the JBoss RestEasy framework and save myself time the next time I need it. 
It is being placed here to serve as a guide on how to get started with RestEasy and is not meant to be a final project. 
If you wish to use this project as a base to your own please clone than copy files to your own project. 

It is a Maven project so if your IDE supports Maven you should be able to import easily using and existing pom file.

RestEasy is a servlet based rest service so this project will compile into a war file and can be installed as a Tomcat web application.
</div>

<div>
<p>Usage:</p> 
This example provides one example entry point API called /get/status which is define in the GetStatusResource class. This API entry point is created in the main application class RestServiceApplication using the following pattern:

    private Set<Object> webservices = new HashSet<Object>();

    public RestServiceApplication() {
        initializeRestService(Level.DEBUG);
        webservices.add(new GetStatusResource());
   }


</div>