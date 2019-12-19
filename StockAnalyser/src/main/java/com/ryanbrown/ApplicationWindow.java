package com.ryanbrown;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class ApplicationWindow {

	protected Shell shell;
	private Text websiteInput;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ApplicationWindow window = new ApplicationWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1920, 1080);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(10, 10, 898, 681);
		
		Label enterName = new Label(composite, SWT.NONE);
		enterName.setBounds(335, 56, 170, 32);
		enterName.setText("Enter Name Of Website ");
		enterName.addMouseListener(new TestListener(enterName));
		
		websiteInput = new Text(composite, SWT.BORDER);
		websiteInput.setBounds(335, 119, 170, 32);
		
		Button btnGetInfo = new Button(composite, SWT.NONE);
		btnGetInfo.setBounds(364, 184, 90, 30);
		btnGetInfo.setText("Get Info");
	}
	class TestListener implements MouseListener {
		private Label label;
		
		public TestListener(Label textlabel) {
			label = textlabel;
		}
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseDown(MouseEvent e) {
			
			label.setText("Pressed");
		}

		public void mouseUp(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

