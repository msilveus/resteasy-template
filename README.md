# resteasy-template

<div>
<p>Notes:</p>   

I do not claim ownership to any techniques shown herein as there are many such examples of RestEasy on the web.
This project was created as a simple example of how to use the JBoss RestEasy framework and save myself time the next time I need it. 
It is being placed here to serve as a guide on how to get started with RestEasy and is not meant to be a final project. 
If you wish to use this project as a base to your own please clone than copy files to your own project. 

It is a Maven project so if your IDE supports Maven you should be able to import easily using the included pom file.

RestEasy is a servlet based rest service so this project will compile into a war file and can be installed as a Tomcat web application.
I have also included support for WADL so you can publish your API via a Web call.
</div>

<div>
<p>Usages:</p> 
This example provides one example entry point API called /get/status which is define in the GetStatusResource class. This API entry point is created in the main application class RestServiceApplication using the following pattern:

    private Set<Object> webservices = new HashSet<Object>();

    public RestServiceApplication() {
        initializeRestService(Level.DEBUG);
        webservices.add(new GetStatusResource());
   }


</div>

<div>
<p>WADL call:</p> 
In my example below tomcat is running on port 8084 your usage may be different. 
In order to retrieve the WADL document you can use the following URL call:

Request:
http://localhost:8084/resteasy/application.wadl

Response:<br />
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<application xmlns="http://wadl.dev.java.net/2009/02">
    <resources base="http://localhost:8084/resteasy">
        <resource path="/get/status">
            <resource path="/json">
                <method id="getJSONStatus" name="GET">
                    <response>
                        <representation mediaType="application/json"/>
                    </response>
                </method>
            </resource>
            <resource path="/xml">
                <method id="getXMLStatus" name="GET">
                    <response>
                        <representation mediaType="application/xml"/>
                    </response>
                </method>
            </resource>
            <resource path="/text">
                <method id="getTextStatus" name="GET">
                    <response>
                        <representation mediaType="text/plain"/>
                    </response>
                </method>
            </resource>
            <method id="getStatus" name="GET">
                <response>
                    <representation mediaType="text/plain"/>
                </response>
            </method>
        </resource>
    </resources>
</application>
```
</div>