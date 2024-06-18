package BT_Quản_Lí_Country_dùng_List;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CountryListManager {
    // Dữ liệu được lưu
    private List<AbstractCountry> countryList;

    // Hàm dựng
    public CountryListManager() {
        countryList = new LinkedList<>();
    }
    
    public List<AbstractCountry> getCountryList() {
        return this.countryList;
    }

    // Thêm dữ liệu vào cuối countryList
    public void append(AbstractCountry country) {
        /* TODO */
    	countryList.add(country);
    }

    // Thêm dữ liệu vào vị trí index
    public void add(AbstractCountry country, int index) {
        /* TODO */
    	if(index < 0 || index >= countryList.size()) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
    	}
    	this.countryList.add(index, country);
    }

    // Xóa dữ liệu tại vị trí index
    public void remove(int index) {
        /* TODO */
    	if(index < 0 || index >= countryList.size()) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
    	}
    	this.countryList.remove(index);
    }

    // Xóa các dữ liệu trong countryList
    public void remove(Country country) {
        /* TODO */
    	countryList.removeIf(c -> c.equals(country));
    }

    // Lấy dữ liệu ở vị trí index
    public AbstractCountry countryAt(int index) {
        /* TODO */
    	if(index >= 0 && index < countryList.size()) {
    		return countryList.get(index);
    	}
    	return null;
    }

    // Sắp xếp dữ liệu theo dân số tăng dần.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> sortIncreasingByPopulation() {
        /* TODO */
    	List<AbstractCountry> list = new LinkedList<>(countryList);
    	list.sort(Comparator.comparingInt(AbstractCountry::getPopulation));
    	return list;
    }

    // Sắp xếp dữ liệu theo dân số giảm dần.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> sortDecreasingByPopulation() {
        /* TODO */
    	List<AbstractCountry> list = new LinkedList<>(countryList);
    	list.sort((c1,c2) -> Integer.compare(c2.getPopulation(), c1.getPopulation()));
    	return list;
    }

    // Sắp xếp dữ liệu theo diện tích tăng dần.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> sortIncreasingByArea() {
        /* TODO */
    	List<AbstractCountry> list = new LinkedList<>(countryList);
    	list.sort(Comparator.comparingDouble(AbstractCountry::getArea));
    	return list;
    }

    // Sắp xếp dữ liệu theo diện tích giảm dần.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> sortDecreasingByArea() {
        /* TODO */
    	List<AbstractCountry> list = new LinkedList<>(countryList);
    	list.sort((c1,c2) -> Double.compare(c2.getArea(), c1.getArea()));
    	return list;
    }

    // Sắp xếp dữ liệu theo GDP tăng dần.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> sortIncreasingByGdp() {
        /* TODO */
    	List<AbstractCountry> list = new LinkedList<>(countryList);
    	list.sort(Comparator.comparingDouble(AbstractCountry::getGdp));
    	return list;
    }

    // Sắp xếp dữ liệu theo GDP giảm dần.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> sortDecreasingByGdp() {
        /* TODO */
    	List<AbstractCountry> list = new LinkedList<>(countryList);
    	list.sort((c1,c2) -> Double.compare(c2.getGdp(), c1.getGdp()));
    	return list;
    }

    // Lọc dữ liệu theo continent.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> filterContinent(String continent) {
        /* TODO */
    	List<AbstractCountry> fl = new LinkedList<>();
    	for(AbstractCountry country : countryList) {
    		if(country.getContinent().equals(continent)) {
    			fl.add(country);
    		}
    	}
    	return fl;
    }
    
    // Lọc ra howMany nước đông dân nhất.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> filterMostPopulousCountries(int howMany) {
        /* TODO */
    	List<AbstractCountry> sl = sortDecreasingByPopulation();
    	return sl.subList(0, Math.min(howMany, sl.size()));
    }

    // Lọc ra howMany nước ít dân nhất.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> filterLeastPopulousCountries(int howMany) {
        /* TODO */
    	List<AbstractCountry> sl = sortIncreasingByPopulation();
    	return sl.subList(0, Math.min(howMany, sl.size()));
    }

    // Lọc ra howMany nước có diện tích lớn nhất.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> filterLargestAreaCountries(int howMany) {
        /* TODO */
    	List<AbstractCountry> sl = sortIncreasingByArea();
    	return sl.subList(0, Math.min(howMany, sl.size()));
    }
    
    // Lọc ra howMany nước có diện tích nhỏ nhất.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> filterSmallestAreaCountries(int howMany) {
        /* TODO */
    	List<AbstractCountry> sl = sortDecreasingByArea();
    	return sl.subList(0, Math.min(howMany, sl.size()));
    }

    // Lọc ra howMany nước có GDP cao nhất.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> filterHighestGdpCountries(int howMany) {
        /* TODO */
    	List<AbstractCountry> sl = sortDecreasingByGdp();
    	return sl.subList(0, Math.min(howMany, sl.size()));
    }

    // Lọc ra howMany nước có GDP thấp nhất.
    // Lưu và trả ra một list mới, không thay đổi list dữ liệu gốc.
    public List<AbstractCountry> filterLowestGdpCountries(int howMany) {
        /* TODO */
    	List<AbstractCountry> sl = sortIncreasingByGdp();
    	return sl.subList(0, Math.min(howMany, sl.size()));
    }

    public static String codeOfCountriesToString(List<AbstractCountry> countryList) {
        StringBuilder codeOfCountries = new StringBuilder();
        codeOfCountries.append("[");
        for (AbstractCountry country : countryList) {
            codeOfCountries.append(country.getCode()).append(" ");
        }
        return codeOfCountries.toString().trim() + "]";
    }

    public static void print(List<AbstractCountry> countryList) {
        StringBuilder countriesString = new StringBuilder();
        countriesString.append("[");
        for (AbstractCountry country : countryList) {
            countriesString.append(country.toString()).append("\n");
        }
        System.out.print(countriesString.toString().trim() + "]");
    }
}