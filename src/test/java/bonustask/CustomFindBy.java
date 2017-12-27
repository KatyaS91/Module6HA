package bonustask;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.pagefactory.Annotations;

import java.lang.reflect.Field;

/**
 * Created by Katsiaryna_Skarzhyns on 12/27/2017.
 */
public class CustomFindBy extends Annotations {

	CustomFindBy(Field field) {
		super(field);
	}

	protected By buildByFromLongFindBy(FindBy findBy) {
		How how = findBy.how();
		String using = findBy.using();

		switch (how) {
		case CLASS_NAME:
			return By.className(using);
		case ID:
			return By.id(using);
		case ID_OR_NAME:
			return new ByIdOrName(using);
		case LINK_TEXT:
			return By.linkText(using);
		case NAME:
			return By.name(using);
		case PARTIAL_LINK_TEXT:
			return By.partialLinkText(using);
		case TAG_NAME:
			return By.tagName(using);
		case XPATH:
			return By.xpath(using);
		case CSS:
			return By.cssSelector(using);
		default:
			throw new IllegalArgumentException("Cannot determine how to locate element ");
		}
	}
}