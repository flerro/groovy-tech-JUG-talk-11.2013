@Grapes([
    @Grab("org.gebish:geb-core:0.9.0"),
    @Grab("org.seleniumhq.selenium:selenium-firefox-driver:2.32.0"),
    @Grab("org.seleniumhq.selenium:selenium-support:2.32.0")
])
import geb.*
   
Browser.drive {
  go "http://www.google.com/"
  assert title == "Google"
 
  $("input", name: "q").value("wikipedia")
  $("input", value: "btnG").click()
  
  waitFor { title.endsWith("Google Search") }
       
  def firstResultLink = $("li.g", 0).find("a")
  
  assert firstResultLink.text().startsWith("Wikipedia")
  
  firstResultLink.click()
  
  waitFor { title.endsWith("Wikipedia") }
  
}
