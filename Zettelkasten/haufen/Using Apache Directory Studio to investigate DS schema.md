After Logging into a directory server navigate to an object. right click to produce a context menu from which you can select "Schema Browser"
![ViewingSchemaBrowser_ApacheDirStudio](Zettelkasten/media/ApacheDirectoryStudio/ViewingSchemaBrowser_ApacheDirStudio.gif)

The left panel shows attributes available in the schema, the right shows details relative to those attributes. The details may seem a bit backwards, when you select an attribute, the "Used as MUST" section in the details lists objects which require the selected attribute. "Used as MAY" shows object which CAN use it but dont require it, as the name suggests. 

if an attribute isn't available to an object, that's means the object doesn't have a necessary objectClass attribute. say you want to add a "homeCity" attribute to this gTorphy user object (see below). when we use the Schema Browser to see the attribute details for 'HomeCity', we see that only 'homeInfo' can use that attribute. 
![[Zettelkasten/media/ApacheDirectoryStudio/SchemaBrowser_homeCityAttr.png.png]]
including the 'homeInfo' class in the gTorphy user permits the `homeCity` attribute to be used in the gTorphy user object. 
![](Zettelkasten/media/Adding_homeInfo_aux_class(and_home_city_attribute).gif)