package com.projectweek2.PROJECT_WEEK_2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.projectweek2.model.Car;
import com.projectweek2.repositories.BbddInMemory;

/**
 * La clase para realizar los test a nuestra principales funciones
 */
@SpringBootTest
class ProjectWeek2ApplicationTests {

	@BeforeEach
	public void setUp() {
		// Reiniciar la lista de coches antes de cada prueba
		BbddInMemory.getListOfVehicles().clear();
	}

	/**
	 * Nos aseguramos de que cuando guardamos un coche en la lista, debe tener un tamaño de 1
	 * ademas el coche guardado debe ser igual al de la lista
	 */
	@Test
	public void testSaveCar() {
		Car carToSave = new Car("Toyota", "Corolla", 25000, 150, "Gasoline");
		BbddInMemory.saveCar(carToSave);
		List<Car> vehicles = BbddInMemory.getListOfVehicles();
		assertEquals(1, vehicles.size()); // Debería haber un coche en la lista
		assertEquals(carToSave, vehicles.get(0)); // El coche en la lista debe ser igual al coche guardado
	}

	@Test
	public void testDeleteCar() {
		Car carToDelete = new Car("Toyota", "Corolla", 25000, 150, "Gasoline");
		BbddInMemory.saveCar(carToDelete);
		int carId = carToDelete.getId();

		BbddInMemory.deleteCar(carId);
		List<Car> vehicles = BbddInMemory.getListOfVehicles();
		assertEquals(0, vehicles.size()); // La lista debe estar vacía después de eliminar el coche
	}

	@Test
	public void testFindById() {
		Car carToFind = new Car("Toyota", "Corolla", 25000, 150, "Gasoline");
		BbddInMemory.saveCar(carToFind);
		int carId = carToFind.getId();

		Car foundCar = BbddInMemory.findById(carId);
		assertNotNull(foundCar); // Debe encontrar un coche con el ID proporcionado
		assertEquals(carToFind, foundCar); // El coche encontrado debe ser igual al coche guardado
	}

    @Test
    public void testUpdateCar() {
        Car carToUpdate = new Car("Toyota", "Corolla", 25000, 150, "Gasoline");
        BbddInMemory.saveCar(carToUpdate);
        int carId = carToUpdate.getId();

        Car updatedCar = new Car("Honda", "Civic", 28000, 170, "Gasoline");
        updatedCar.setId(carId);

        BbddInMemory.updateCar(updatedCar);

        Car foundCar = BbddInMemory.findById(carId);
        assertNotNull(foundCar);
        assertEquals(updatedCar, foundCar); // El coche encontrado debe ser igual al coche actualizado
    }

}
