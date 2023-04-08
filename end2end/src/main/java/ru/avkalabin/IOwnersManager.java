package ru.avkalabin;

import ru.avkalabin.domain.Owner;

import java.util.List;

public interface IOwnersManager {
	int createOwner(Owner owner);

	void deleteOwner(int id);

	List<Owner> findByLastName(String lastName);
}
