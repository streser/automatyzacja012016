package eu.ekinnolab.page_object_way;

import org.junit.*;

import eu.ekinnolab.page_object_way.pages.*;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class PostsTest extends Base {
	
	@Test
	public void shouldBePossibleToAddNewBlogPost() {
		
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		AdminPage adminPage = loginPage.correctLogin();
		
		AddNewPostPage addNewPostPage = adminPage.goToAddNewPostPage();
		
		String title = "Kamil post, time: " + System.currentTimeMillis();
		addNewPostPage.addNewPost(title);
		
		PostsListPage postListPage = addNewPostPage.goToPostsList();
		Assert.assertTrue(postListPage.isPostPresent(title));
	}
}
