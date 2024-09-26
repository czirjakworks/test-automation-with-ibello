package ibello.pages.component;

import hu.ibello.core.TestException;
import hu.ibello.elements.WebElement;
import hu.ibello.elements.WebElements;
import hu.ibello.pages.PageObject;
import hu.ibello.search.By;
import hu.ibello.search.Find;

import java.util.ArrayList;
import java.util.List;

public class TableComponent extends PageObject {

    @Find(by = By.CSS_SELECTOR, using = "table")
    WebElement table;

    protected WebElement getTable() {
        return table;
    }

    protected WebElement getFirstRow() {
        WebElements rows = getBodyRows();
        return rows.get(0);
    }

    protected void expect_$_rows_are_visible(int rows) {
        expectations().expect(getBodyRows()).toHave().size(rows);
    }

    protected void expect_table_has_more_than_one_rows() {
        WebElements rows = getBodyRows();
        expectations().expect(rows).toHave().sizeGreaterThan(1);
    }

    protected void expect_minimum_one_case_exists() {
        WebElements rows = getBodyRows();
        expectations().expect(rows).toHave().sizeGreaterThan(0);
    }

    protected List<WebElement> getRowsWithValueInCell(String value, int columnIndex) {
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
            throw new TestException("No rows found where columnIndex: " + columnIndex + ", value: " + value + ".");
        }
        return rows;
    }

    protected WebElements getCells(WebElement row) {
        return row.find().using(By.CSS_SELECTOR, "td").all();
    }


    private WebElements getBodyRows() {
        return getTable().find().using(By.CSS_SELECTOR, "tbody tr").all();
    }



}
