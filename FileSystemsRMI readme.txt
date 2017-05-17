1. All the given requirements are fullfilled and the source code supports all the
commands.

2. The environment varaiable can be set as follows in the command prompt:
set PA1_SERVER=IP-address
The IP-address of the computer should be given like 196.168.1.155

3. The execution should be in the following way. 
	- First start the rmiregistry as follows:
		start rmiregistry <port-number>
	Usually the port number is given as 1099 or 2001.
	- Then start the stub creation as follows:
		rmic FileImpl
	Please use the above command exactly the same.
	-Now the server can be started as follows:
		java FileServer
	-Now another Command prompt is opened and the client can be started as follows:
		java FileClient <operation> <path> ....
Please use the Server name as FileServer and client name as FileClient as the classes
are defined in that way.

4. The server stores the uploaded files in the given location of command i.e.,
when we use the command "java Client upload <client-path> <server-path>"
the server-path is the location of the storage in server.

5. All the given commands can be executed as given.

6. Some of the code has been taken from the following sites while the code was 
being developed initially.
	http://www.studygate.in/distributed-application-in-java-to-download-various-files-from-various-servers-using-rmi/