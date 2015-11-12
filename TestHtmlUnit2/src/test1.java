import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.Cookie;

public class test1 {
	
	public static void main(String args[]) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		
		webClient.getOptions().setJavaScriptEnabled(false);

		webClient.getOptions().setCssEnabled(false);
		
		CookieManager cookieManager = new CookieManager();
		cookieManager.addCookie(new Cookie("tieba.baidu.com", "BDUSS", "lJVaWV6ZUQ4blgxWi1DOG44S1FTMDEzN0JmaVYyZlFPSEZjbGw2QTNXVG40azFXQVFBQUFBJCQAAAAAAAAAAAEAAAA22wQy1tC2~rKhu7wyMzMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAOdVJlbnVSZWQ"));
		webClient.setCookieManager(cookieManager);
		
		HtmlPage page = webClient.getPage("http://tieba.baidu.com/mo/m?kw=%E8%8C%82%E5%90%8D%E5%B8%82%E7%AC%AC%E4%B8%80%E4%B8%AD%E5%AD%A6");
		
		int o=0;
		
		while(o<2) {
			
			//HtmlPage page = webClient.getPage("http://tieba.baidu.com/mo/m?kw=%E8%8C%82%E5%90%8D%E5%B8%82%E7%AC%AC%E4%B8%80%E4%B8%AD%E5%AD%A6");
			
			DomNodeList<DomNode> iList = page.querySelectorAll(".i");
			

			for(DomNode i: iList) {
				// 选择 p 元素
				DomNode p = i.querySelector("p");
				// asText() 返回 元素文本， contains是 String的方法，查找 "回0 " 字符串
				//if(p.asText().contains("回0 ")) {
				// 这里就是找到了 回帖为0的帖子
				// 我们用 父元素 div.i 来继续获取 子元素 a 标签。
				HtmlAnchor a = (HtmlAnchor)i.querySelector("a");
				
				System.out.println(a.asText());

				// 获取 a 标签的属性 href ，就是帖子详情的地址啦！！
				//String href = a.getAttribute("href");
				// TODO
				//HtmlPage tPage = webClient.getPage("http://tieba.baidu.com" + href);
				
				//System.out.println(tPage.asText());
				
				//HtmlInput co = (HtmlInput)tPage.querySelector("input[name=co]");
				
				
				
				//co.setValueAttribute("全体回复测试");
				
				//HtmlInput sub1 = (HtmlInput)tPage.querySelector("input[name=sub1]");
				
				//sub1.click();
				
				
				//}
				}
			
			//实现点击下一页
			
			HtmlElement button = page.getHtmlElementByAccessKey('6');
			
			System.out.println(button.asText());
			
			page = (HtmlPage)button.click();
			
			o++;
			
			}
		
		
	}

}
