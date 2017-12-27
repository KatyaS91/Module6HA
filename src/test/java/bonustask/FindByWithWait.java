package bonustask;

import org.openqa.selenium.By;
import org.openqa.selenium.support.AbstractFindByBuilder;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FindByWithWait {
	How how() default How.UNSET;

	String using() default "";

	String id() default "";

	String name() default "";

	String className() default "";

	String css() default "";

	String tagName() default "";

	String linkText() default "";

	String partialLinkText() default "";

	String xpath() default "";

	public static class FindByBuilder extends AbstractFindByBuilder {
		public FindByBuilder() {
		}

		public By buildIt(Object annotation, Field field) {
			FindBy findBy = (FindBy)annotation;
			this.assertValidFindBy(findBy);
			By ans = this.buildByFromShortFindBy(findBy);
			if(ans == null) {
				ans = this.buildByFromLongFindBy(findBy);
			}

			return ans;
		}
	}
	long time() default 3000;
}