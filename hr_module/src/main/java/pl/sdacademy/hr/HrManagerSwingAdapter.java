package pl.sdacademy.hr;

import javax.swing.table.DefaultTableModel;

public class HrManagerSwingAdapter {
		private HrManager hrManager;
		public HrManagerSwingAdapter(HrManager hrManager) {
			this.hrManager = hrManager;
		}
		public void addNewEmployee(DefaultTableModel tableModel, String firstName, String lastName, String
			dateOfBirth){
			Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);
			tableModel.addRow(new Object[]{newEmployee.getFirsName(), newEmployee.getLastName(), newEmployee
				.getDateOfBirth()});
		}
	}


