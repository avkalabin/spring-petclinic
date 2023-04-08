package ru.avkalabin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.avkalabin.domain.Owner;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddOwnerTest {

	private final IOwnersManager om = new OwnersManagerNG();


	@Test
	void checkAddOwner() {

		open("http://localhost:8080/owners/find");
		$(byTagAndText("a", "Add Owner")).click();
		$("#firstName").setValue("Stas");
		$("#lastName").setValue("Vasenkov");
		$("#address").setValue("Motenegro");
		$("#city").setValue("Budva");
		$("#telephone").setValue("5555555");
		$("button[type ='submit']").click();
		Owner actualOwner = om.findByLastName("Vasenkov").get(0);
		Assertions.assertEquals("Budva",actualOwner.getCity());



	}
}
