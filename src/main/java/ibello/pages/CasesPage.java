package ibello.pages;
import hu.ibello.core.Name;
import hu.ibello.core.TestException;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;
import ibello.data.Case;

import java.util.ArrayList;
import java.util.List;


@Name("Cases page")
public class CasesPage extends PageObject {

    private static final String URL = "https://ibello.hu/tasks/cases/#/cases";

    @Find(by = By.CLASS_NAME, using = "panel-title")
    private WebElement casesTitle;

    @Find(by = By.CLASS_NAME, using = "table table-hover")
    private WebElement casesTable;

    public void open_page(){
        browser().openURL(URL);
        browser().resize(1920, 1080);
        browser().maximize();
    }

    public void page_must_be_loaded() {
        String text=getConfigurationValue("demo.cases.title").toString();
        expectations().expect(casesTitle).toHave().textOrValue(text);
    }

    public void case_exists_with_$_name(String $_name) {
       List<WebElement> elements = getRowsWithValueInCell($_name, 2);
       expectations().expect(elements).toHave().size(1);
    }

    public void expect_table_has_more_than_one_rows() {
        WebElements rows = getBodyRows();
        expectations().expect(rows).toHave().sizeGreaterThan(1);
    }

    public void click_first_case_id() {
        WebElements rows = getBodyRows();
        WebElement firstRow = rows.get(0);
        WebElement firstId = firstRow.find().using(By.CSS_SELECTOR, "td a").first();
        doWith(firstId).click();
    }

    private List<WebElement> getRowsWithValueInCell(String value, int columnIndex) {
        List<WebElement> rows = new ArrayList<>();
        WebElements bodyRows = getBodyRows();
        for (int i=0; i<bodyRows.size(); i++) {
            WebElement row = bodyRows.get(i);
            WebElement cell = row.find().using(By.CSS_SELECTOR, "td").all().get(columnIndex);
            if (get(cell).text().equals(value)) {
                rows.add(row);
            }
        }
        if (rows.isEmpty()) {
            throw new TestException("No rows found where columnIndex: " + columnIndex + ", value: " + value);
        }
        return rows;
    }

    private WebElements getBodyRows() {
        return casesTable.find().using(By.CSS_SELECTOR, "tbody tr").all();
    }





}
