package ibello.pages;

import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.search.By;
import ibello.pages.component.TableComponent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public class CasesTable extends TableComponent {

    public void click_first_case_id() {
        WebElement firstRow = getFirstRow();
        WebElement firstIdTd = getCells(firstRow).get(0);
        WebElement firstId = getChildLink(firstIdTd);
        doWith(firstId).click();
    }

    public void case_exists_with_$_name(String name) {
        List<WebElement> elements = getRowsWithValueInCell(name, 2);
        expectations().assume(elements).toHave().size(1);
    }

    public void expect_minimum_one_case_exists() {
        expect_table_has_more_than_one_rows();
    }

    public void expect_exactly_$_case_exists(int count) {
        expect_$_rows_are_visible(count);
    }

    public void expect_first_row_has_id() {
        WebElement firstRow = getFirstRow();
        WebElement firstId = getCells(firstRow).get(0);
        expectations().expect(firstId).toHave().textOrValue(Pattern.compile("^\\d+$"));
    }

    public void expect_first_row_has_$_name(String name) {
        WebElement firstRow = getFirstRow();
        WebElement firstName = getCells(firstRow).get(2);
        expectations().expect(firstName).toHave().textOrValue(name);
    }

    public void expect_first_row_has_$_status(String status) {
        WebElement firstRow = getFirstRow();
        WebElement firstStatus = getCells(firstRow).get(1);
        expectations().expect(firstStatus).toHave().textOrValue(status);
    }

    public void expect_first_row_has_$_person(String person) {
        WebElement firstRow = getFirstRow();
        WebElement firstPerson = getCells(firstRow).get(3);
        expectations().expect(firstPerson).toHave().textOrValue(person);
    }

    public void expect_first_row_has_$_date(LocalDate date) {
        String dateFormat = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        WebElement firstRow = getFirstRow();
        WebElement firstDate = getCells(firstRow).get(4);
        expectations().expect(firstDate).toHave().textOrValue(dateFormat);
    }

    public void expect_first_row_has_$_responsible(String responsible) {
        WebElement firstRow = getFirstRow();
        WebElement firstResponsible = getCells(firstRow).get(5);
        expectations().expect(firstResponsible).toHave().textOrValue(responsible);
    }

    private WebElement getChildLink(WebElement cell) {
        return cell.find().using(By.CSS_SELECTOR, "a").first();
    }

}
