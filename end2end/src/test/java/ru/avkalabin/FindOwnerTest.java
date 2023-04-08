package ru.avkalabin;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import ru.avkalabin.domain.Owner;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FindOwnerTest {

	IOwnersManager om = new OwnersManagerNG();
	private int createdOwnerId;

	@BeforeEach
	void addOwner() {
		createdOwnerId = om.createOwner(Owner.builder()
				.firstName("Oleg")
				.lastName("Semenov")
				.address("Russia")
				.city("Perm")
				.telephone("8400354245")
			.build());
	}

	@AfterEach
	void deleteOwner() {
		om.deleteOwner(createdOwnerId);
	}

	@RepeatedTest(2)
	void findOwnerTest() {
		System.out.println(createdOwnerId);
		Selenide.open("http://localhost:8080/owners/find");
		$("#lastName").setValue("Semenov");
		$("button[type='submit']").click();
		$("table.table").shouldBe(Condition.visible);
		$$("tr").find(text("Name")).shouldHave(text("Oleg Semenov"));
	}
}
