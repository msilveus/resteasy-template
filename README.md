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
In order to retrieve the WADL document you can use the following URL:

Request:
http://localhost:8084/resteasy/application.wadl

Response:<br />
&lt;application xmlns="http://wadl.dev.java.net/2009/02"&gt;<br />
<p style="margin-left: 40px">
&lt;resources base="http://localhost:8084/resteasy"&gt;<br />
&lt;resource path="/get/status"&gt;<br />
&lt;resource path="/json"&gt;<br />
&lt;method id="getJSONStatus" name="GET"&gt;<br />
&lt;response&gt;<br />
&lt;representation mediaType="application/json"/&gt;<br />
&lt;/response&gt;<br />
&lt;/method&gt;<br />
&lt;/resource&gt;<br />
&lt;resource path="/text"&gt;<br />
&lt;method id="getTextStatus" name="GET"&gt;<br />
&lt;response&gt;<br />
&lt;representation mediaType="text/plain"/&gt;<br />
&lt;/response&gt;<br />
&lt;/method&gt;<br />
&lt;/resource&gt;<br />
&lt;resource path="/xml"&gt;<br />
&lt;method id="getXMLStatus" name="GET"&gt;<br />
&lt;response&gt;<br />
&lt;representation mediaType="application/xml"/&gt;<br />
&lt;/response&gt;<br />
&lt;/method&gt;<br />
&lt;/resource&gt;<br />
&lt;method id="getStatus" name="GET"&gt;<br />
&lt;response&gt;<br />
&lt;representation mediaType="text/plain"/&gt;<br />
&lt;/response&gt;<br />
&lt;/method&gt;<br />
&lt;/resource&gt;<br />
&lt;/resources&gt;<br />
</p>
&lt;/application&gt;<br />

</div>