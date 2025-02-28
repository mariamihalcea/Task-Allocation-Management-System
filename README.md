# AWJ Project  

## Author  
Mihalcea Maria-Alexandra  

## Description  
This application manages employees, clients, and services for a home service company.  

## Features  

### Core Features  
- **Employee Management**  
  - Add, edit, and delete employees  
  - List all employees  

- **Client Management**  
  - Add, edit, and delete clients  
  - List all clients  

- **Service Management**  
  - Add and delete services  
  - List available services  

### Additional Features  
- **Data Validation**  
  - Names must start with an uppercase letter  
  - Phone numbers must contain only digits  
  - Email must follow the format *@email.com*  

## Project Structure  

### Employee Controller  
- `listEmployees(Model model)`: Displays the list of employees  
- `showAddEmployeeForm()`: Shows the add employee form  
- `addEmployee(...)`: Adds a new employee and validates the data  
- `showEditEmployeeForm(Integer id, Model model)`: Displays the edit form  
- `editEmployee(...)`: Saves the modifications  
- `deleteEmployee(Integer employeeId, Model model)`: Deletes an employee  

### Client Controller  
- `listClients(Model model)`: Displays the list of clients  
- `showAddClientForm()`: Shows the add client form  
- `addClient(...)`: Adds and validates a client  
- `showEditClientForm(Integer id, Model model)`: Displays the edit form  
- `editClient(...)`: Saves modifications  
- `deleteClient(Integer clientId, Model model)`: Deletes a client  

### Service Controller  
- `listServices(Model model)`: Displays available services  
- `showAddServiceForm()`: Shows the add service form  
- `addService(...)`: Adds a new service  
- `deleteService(Integer idServiciu, Model model)`: Deletes a service  

## User Interface  
- Pages for managing employees, clients, and services  
- Error messages displayed when invalid data is entered  

## Testing  
- Manual testing of the graphical user interface  
- Verification of correct error messages for invalid input  

## Potential Improvements  
1. **Authentication & Authorization** – Restrict access to authorized users  
2. **Pagination** – Prevent overload when listing employees, clients, or services  
3. **Search & Filtering** – Improve data retrieval  
4. **More Intuitive Menu** – Include client orders for better management  
5. **Notification System** – Email or in-app notifications for important events  


