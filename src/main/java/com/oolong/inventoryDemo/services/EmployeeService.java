package com.oolong.java3mtp.services;

import com.oolong.java3mtp.dto.EmployeeDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class EmployeeService extends Service<EmployeeDto> {

    //base query and search options,
    //search options are shown as radio menu on UI
    public EmployeeService() {
        super("SELECT \n" +
                "    e.EmployeeID,\n" +
                "    e.LastName,\n" +
                "    e.FirstName,\n" +
                "    e.Title,\n" +
                "    e.BirthDate,\n" +
                "    e.HireDate,\n" +
                "    e.Address,\n" +
                "    e.City,\n" +
                "    e.HomePhone,\n" +
                "    e.Extension,\n" +
                "    e.Notes,\n" +
                "    m.LastName AS ManagerLastName\n" +
                "FROM java3mtp.employees e\n" +
                "LEFT JOIN java3mtp.employees m\n" +
                "    ON e.ReportsTo = m.EmployeeID ",

                Map.of(
                       "Id", "e.EmployeeId",
                       "Last Name", "e.LastName",
                       "Birth Date", "e.BirthDate",
                       "Phone Number", "e.HomePhone",
                        "Extension", "e.Extension"
                ));
    }


    //helper class to build row data to a Dto for the GUI to show
    @Override
    protected EmployeeDto createRow(ResultSet resultSet) throws SQLException {
        return new EmployeeDto(
                resultSet.getInt("EmployeeID"),
                resultSet.getString("LastName"),
                resultSet.getString("FirstName"),
                resultSet.getString("Title"),
                resultSet.getString("BirthDate"),
                resultSet.getString("HireDate"),
                resultSet.getString("Address"),
                resultSet.getString("City"),
                resultSet.getString("HomePhone"),
                resultSet.getInt("Extension"),
                resultSet.getString("Notes"),
                resultSet.getString("ManagerLastName")
        );
    }
}
