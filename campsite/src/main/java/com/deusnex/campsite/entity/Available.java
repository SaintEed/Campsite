package com.deusnex.campsite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="available")
public class Available {

	//Fields
	
	@Column(name="date")
	private String date;
	
	@Column(name="plot_1")
	private int plot1;
	
	@Column(name="plot_2")
	private int plot2;
	
	@Column(name="plot_3")
	private int plot3;
	
	@Column(name="plot_4")
	private int plot4;
	
	@Column(name="plot_5")
	private int plot5;
	
	@Column(name="plot_6")
	private int plot6;
	
	@Column(name="plot_7")
	private int plot7;
	
	@Column(name="plot_8")
	private int plot8;
	
	@Column(name="plot_9")
	private int plot9;
	
	@Column(name="plot_10")
	private int plot10;
	
	@Column(name="plot_11")
	private int plot11;
	
	@Column(name="plot_12")
	private int plot12;
	
	//Constructors
	
	public Available() {
		
	}

	public Available(String date, int plot1, int plot2, int plot3, int plot4, int plot5, int plot6, int plot7,
			int plot8, int plot9, int plot10, int plot11, int plot12) {
		this.date = date;
		this.plot1 = plot1;
		this.plot2 = plot2;
		this.plot3 = plot3;
		this.plot4 = plot4;
		this.plot5 = plot5;
		this.plot6 = plot6;
		this.plot7 = plot7;
		this.plot8 = plot8;
		this.plot9 = plot9;
		this.plot10 = plot10;
		this.plot11 = plot11;
		this.plot12 = plot12;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPlot1() {
		return plot1;
	}

	public void setPlot1(int plot1) {
		this.plot1 = plot1;
	}

	public int getPlot2() {
		return plot2;
	}

	public void setPlot2(int plot2) {
		this.plot2 = plot2;
	}

	public int getPlot3() {
		return plot3;
	}

	public void setPlot3(int plot3) {
		this.plot3 = plot3;
	}

	public int getPlot4() {
		return plot4;
	}

	public void setPlot4(int plot4) {
		this.plot4 = plot4;
	}

	public int getPlot5() {
		return plot5;
	}

	public void setPlot5(int plot5) {
		this.plot5 = plot5;
	}

	public int getPlot6() {
		return plot6;
	}

	public void setPlot6(int plot6) {
		this.plot6 = plot6;
	}

	public int getPlot7() {
		return plot7;
	}

	public void setPlot7(int plot7) {
		this.plot7 = plot7;
	}

	public int getPlot8() {
		return plot8;
	}

	public void setPlot8(int plot8) {
		this.plot8 = plot8;
	}

	public int getPlot9() {
		return plot9;
	}

	public void setPlot9(int plot9) {
		this.plot9 = plot9;
	}

	public int getPlot10() {
		return plot10;
	}

	public void setPlot10(int plot10) {
		this.plot10 = plot10;
	}

	public int getPlot11() {
		return plot11;
	}

	public void setPlot11(int plot11) {
		this.plot11 = plot11;
	}

	public int getPlot12() {
		return plot12;
	}

	public void setPlot12(int plot12) {
		this.plot12 = plot12;
	}

	@Override
	public String toString() {
		return "Available [date=" + date + ", plot1=" + plot1 + ", plot2=" + plot2 + ", plot3=" + plot3 + ", plot4="
				+ plot4 + ", plot5=" + plot5 + ", plot6=" + plot6 + ", plot7=" + plot7 + ", plot8=" + plot8 + ", plot9="
				+ plot9 + ", plot10=" + plot10 + ", plot11=" + plot11 + ", plot12=" + plot12 + "]";
	}
	
	
}
