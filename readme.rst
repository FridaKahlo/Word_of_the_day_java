Overview
--------


This program is an experiment in Java to download the word of the day and its image from dexonline

Requirements
============

- Connect to ``dexonline.ro`` over http
- Get the url for today's word
- Access that url and use ``xpath`` to extract:

	- the link to the image
	- the word of the day
	- the definition of the word
	
- Store these in a local ``SQLite`` database

Sequence diagram
================
::

					 +-------+                                       +------+          +--------+     
					 ¦Program¦                                       ¦Server¦          ¦Database¦     
					 +-------+                                       +------+          +--------+     
						 ¦                                              ¦                  ¦          
						 ¦                +--------------------+        ¦                  ¦          
	---------------------+----------------¦ Retrieving the data¦--------+------------------+----------
						 ¦                +--------------------+        ¦                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦               GET dexonline.ro               ¦                  ¦          
						 ¦---------------------------------------------->                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦                Page html body                ¦                  ¦          
						 ¦<----------------------------------------------                  ¦          
						 ¦                                              ¦                  ¦          
		  +------------------------------+                              ¦                  ¦          
		  ¦Now we have the page locally ¦¦                              ¦                  ¦          
		  +------------------------------+                              ¦                  ¦          
						 ----+                                                             ¦          
							 ¦ word_url = Extract url for word of the day                  ¦          
						 <---+                                                             ¦          
						 ¦                                              ¦                  ¦          
						 ¦                 GET word_url                 ¦                  ¦          
						 ¦---------------------------------------------->                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦        Word of the day page html body        ¦                  ¦          
						 ¦<----------------------------------------------                  ¦          
						 ¦                                              ¦                  ¦          
	  +--------------------------------------+                          ¦                  ¦          
	  ¦Now we have the Word of the day page ¦¦                          ¦                  ¦          
	  +--------------------------------------+                          ¦                  ¦          
						 ----+                                          ¦                  ¦          
							 ¦ Extract the word of the day using xpath  ¦                  ¦          
						 <---+                                          ¦                  ¦          
						 ¦                                              ¦                  ¦          
						 ----+                                          ¦                  ¦          
							 ¦ Extract the definition using xpath       ¦                  ¦          
						 <---+                                          ¦                  ¦          
						 ¦                                              ¦                  ¦          
						 ----+                                          ¦                  ¦          
							 ¦ image_url = Extract the url of the image ¦                  ¦          
						 <---+                                          ¦                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦                GET image_url                 ¦                  ¦          
						 ¦---------------------------------------------->                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦                    image                     ¦                  ¦          
						 ¦<----------------------------------------------                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦                      +--------+              ¦                  ¦          
	---------------------+----------------------¦ storage¦--------------+------------------+----------
						 ¦                      +--------+              ¦                  ¦          
						 ¦                                              ¦                  ¦          
						 ¦                              to do           ¦                  ¦          
						 ¦----------------------------------------------------------------->          
					 +-------+                                       +------+          +--------+     
					 ¦Program¦                                       ¦Server¦          ¦Database¦     
					 +-------+                                       +------+          +--------+     

Source code of the flow chart
-----------------------------

To transform this into an image go to http://planttext.com and paste the code below, and press the ``Refresh`` button:


::

	@startuml
	
	title "Word of the day"
	==Retrieving the data==
	Program -> Server: GET dexonline.ro
	Program <- Server: Page html body
	Note over Program: Now we have the page locally
	Program -> Program : word_url = Extract url for word of the day
	Program -> Server : GET word_url
	Server -> Program : Word of the day page html body
	Note over Program: Now we have the Word of the day page
	Program -> Program : Extract the word of the day using xpath
	Program-> Program : Extract the definition using xpath
	Program->Program : image_url = Extract the url of the image
	Program -> Server : GET image_url
	Server -> Program : image
	
	==storage==
	Program -> Database : to do
	
	@enduml
	