
* **Custom Queries + REST** Write each of the following queries and connect them to an appropriate controller:
  * get all the whiskies for a particular year
     * `/whiskies/year/1995`
  * get all the whisky from a particular region 
     * `/whiskies/region/Highland`
  * get all the distilleries for a particular region
      * `/distilleries/region/Highland`
  * get all the whisky from a particular distillery that's a specific age (if the whisky has a specific age)
     * `/distilleries/{id}/whiskies/age/{age}`
  * Get distilleries that have whiskies that are 12 years old 
     * `/whiskies/age/12/distilleries`

