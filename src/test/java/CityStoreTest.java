import static org.junit.Assert.*;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;

import java.util.List;

public class CityStoreTest {

    @Test
    public void whenCreate() {
        CityStore cityStore = new CityStore();
        City city = new City("Moscow");
        cityStore.create(city);
        List<City> all = cityStore.findAll();
        assertEquals(city, all.get(0));
    }

    @Test
    public void whenFindAll() {
        CityStore cityStore = new CityStore();
        City city1 = new City("Moscow");
        City city2 = new City("St. Petersburg");
        cityStore.create(city1);
        cityStore.create(city2);
        assertEquals(List.of(city1, city2), cityStore.findAll());
    }

    @Test
    public void whenDelete() {
        CityStore cityStore = new CityStore();
        City city = new City("Moscow");
        cityStore.create(city);
        cityStore.delete(1);
        List<City> all = cityStore.findAll();
        assertThat(all, IsEmptyCollection.empty());
    }

    @Test
    public void whenFindById() {
        CityStore cityStore = new CityStore();
        City city1 = new City("Moscow");
        cityStore.create(city1);
        City city2 = cityStore.findById(1);
        assertEquals(city2.getName(), "Moscow");
    }

    @Test
    public void whenUpdate() {
        CityStore cityStore = new CityStore();
        City city = new City("Moscow");
        cityStore.create(city);
        City city2 = new City("SPB");
        city2.setId(city.getId());
        cityStore.replace(city2);
        City city3 = cityStore.findById(1);
        assertEquals(city3.getName(), "SPB");
    }
}