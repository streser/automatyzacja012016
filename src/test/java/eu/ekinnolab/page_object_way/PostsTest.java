package eu.ekinnolab.page_object_way;

import org.junit.Test;

/**
 * Created by Kamil Tor on 19 sty 2016
 */
public class PostsTest extends Base {
	
	@Test
	public void shouldBePossibleToAddNewBlogPost() {
		
		String title = "Kamil post, time: " + System.currentTimeMillis();
		
		blogOwner.atLoginPage(driver).open()
									.correctLogin()
									.goToAddNewPostPage()
									.addNewPost(title)
									.goToPostsList()
									.goToPrivatePosts()
									.assertPresenceOfPost(title);

	}
}
