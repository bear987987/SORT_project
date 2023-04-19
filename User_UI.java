import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
import java.awt.Toolkit;
import java.awt.Color;

public class User_UI extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup sortgroup = new ButtonGroup();
	private final ButtonGroup rulegroup = new ButtonGroup();
	public User_UI() {
		setTitle("Sort");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 564);
		
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel label = new JLabel("欲排序資料預覽:請輸入欲排序英/數字或選擇輸入方式");
		label.setFont(new Font("新細明體", Font.PLAIN, 20));
		label.setBounds(95, 20, 493, 39);
		contentPane.add(label);
		
		JTextArea input = new JTextArea();
		input.setBounds(55, 53, 567, 151);
		contentPane.add(input);
		JScrollPane scrollPane = new JScrollPane(input);
		scrollPane.setBounds(55, 53, 567, 151);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea();
		output.setEditable(false);
		output.setBounds(55, 238, 567, 213);
		contentPane.add(output);
		JScrollPane scrollPane2 = new JScrollPane(output);
		scrollPane2.setBounds(55, 238, 567, 213);
		contentPane.add(scrollPane2);
		
		JButton pause = new JButton("暫停排序");
		pause.setFont(new Font("新細明體", Font.PLAIN, 20));
		pause.setBounds(55, 461, 118, 25);
		contentPane.add(pause);
		
		JButton stop = new JButton("終止排序");
		stop.setFont(new Font("新細明體", Font.PLAIN, 20));
		stop.setBounds(183, 461, 118, 25);
		contentPane.add(stop);
		
		JButton clear = new JButton("清空");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e!=null)
				{
					input.setText("");
					output.setText("");
				}
			}
		});
		clear.setFont(new Font("新細明體", Font.PLAIN, 20));
		clear.setBounds(311, 461, 100, 25);
		contentPane.add(clear);
		
		JButton exit = new JButton("離開");
		exit.setFont(new Font("新細明體", Font.PLAIN, 20));
		exit.setBounds(522, 461, 100, 25);
		contentPane.add(exit);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu datainput = new JMenu("資料輸入");
		menuBar.add(datainput);
		
		JMenuItem menuItem_1 = new JMenuItem("讀檔輸入");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e!=null)
				{
					File openFile;
					input.setText("");
					output.setText("");
					JFileChooser chooser = new JFileChooser();
					chooser.showOpenDialog(chooser);
					openFile = chooser.getSelectedFile();

					String extname = "";
					String fileName = openFile.getName();
					int index = fileName.lastIndexOf(".");
					if(index == -1){
						JOptionPane.showMessageDialog(contentPane,"檔案錯誤","Error",JOptionPane.ERROR_MESSAGE);
					}
					else{
						extname = fileName.substring(index).toLowerCase();
						if(extname.equals(".txt")){
							int op = JOptionPane.showConfirmDialog(contentPane, 
		    				"確定將檔案輸入?", 
		    				"確認訊息", 
		    				JOptionPane.YES_NO_OPTION,
		    				JOptionPane.WARNING_MESSAGE);
		  					if(op == JOptionPane.NO_OPTION){}
		  					else {
		  						try{
									BufferedReader in = new BufferedReader(new FileReader(openFile));
									String line = in.readLine();
									while(line != null){
		 								input.append(line + "\n");
		  								line = in.readLine();
									}
								}catch(IOException er){
									System.out.println("Error "+er);
								}
							}
						}
						else{
							JOptionPane.showMessageDialog(contentPane, 
							"檔案格式錯誤", 
							"輸入檔案需為txt檔！", 
							JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		datainput.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("資料庫輸入");
		datainput.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("亂數輸入");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e!=null)
				{
					int [] data =new int[128];
					int i;
			        i = (int)(Math.random()*10)+1;
			        //決定來的數是多少(1~1000)
			        int i2;
			        //決定迴圈for迴圈次數
			        for(int i3=0; i3<i; i3++){
			            i2=(int)(Math.random()*1000)+1;
			            data[i3] = i2;
			            
			            input.append(data[i3] + "\n");
			        }

				}
			}
		});
		datainput.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("設定檔輸入");
		datainput.add(menuItem_4);
		
		JMenu algorithm = new JMenu("演算法");
		menuBar.add(algorithm);
		
		JCheckBoxMenuItem insertion = new JCheckBoxMenuItem("Insertion");
		sortgroup.add(insertion);
		algorithm.add(insertion);
		
		JCheckBoxMenuItem selection = new JCheckBoxMenuItem("Selection");
		sortgroup.add(selection);
		algorithm.add(selection);
		
		JCheckBoxMenuItem bubble = new JCheckBoxMenuItem("Bubble");
		sortgroup.add(bubble);
		algorithm.add(bubble);
		
		JCheckBoxMenuItem merge = new JCheckBoxMenuItem("Merge");
		sortgroup.add(merge);
		algorithm.add(merge);
		
		JMenu sort = new JMenu("排序規則");
		menuBar.add(sort);
		
		JCheckBoxMenuItem stobig = new JCheckBoxMenuItem("由小到大");
		rulegroup.add(stobig);
		sort.add(stobig);
		
		JCheckBoxMenuItem bigtos = new JCheckBoxMenuItem("由大到小");
		rulegroup.add(bigtos);
		sort.add(bigtos);
		JButton label_1 = new JButton("開始排序");
		label_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e!=null)
				{
					{
						String getinput;
						String i="";
						getinput = input.getText();
						Sort insertResult = new Sort();
						Sort selectResult = new Sort();
						String inputCheck=getinput.replace(" ","");
						if(inputCheck.equals(""))
							output.setText("沒有輸入任何內容，無法進行排列!");
						else{
							if(stobig.isSelected()){
								if(insertion.isSelected())
								{
				
									insertResult.insertion(getinput);
									i=insertResult.result; 
									output.setText(i);

								}
								else if(selection.isSelected())
								{

									selectResult.selection(getinput);
									i=selectResult.result;
									output.setText(i);
									
								}
							}
							else if(bigtos.isSelected()){
								if(insertion.isSelected())
								{

									insertResult.insertionMax(getinput);
									i=insertResult.result; 
									output.setText(i);
									
								}
								else if(selection.isSelected())
								{

									selectResult.selectionMax(getinput);
									i=selectResult.result;
									output.setText(i);
									
								}
							}
						}
					}
				}
			}
		});
		label_1.setFont(new Font("新細明體", Font.PLAIN, 20));
		label_1.setBounds(288, 205, 123, 33);
		contentPane.add(label_1);
		
		
	}
}
