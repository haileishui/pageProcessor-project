package com.lmw.domain;

import java.io.Serializable;

public class Gaokao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String zhuanyemingcheng;
	private String gaoxiaomingcheng;
	private String pingjunfen;
	private String zuigaofen;
	private String kaoshengdiqu;
	private String kebie;
	private String nianfen;
	private String pici;
	private String zhuanyeduibi;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getZhuanyemingcheng() {
		return zhuanyemingcheng;
	}

	public void setZhuanyemingcheng(String zhuanyemingcheng) {
		this.zhuanyemingcheng = zhuanyemingcheng;
	}

	public String getGaoxiaomingcheng() {
		return gaoxiaomingcheng;
	}

	public void setGaoxiaomingcheng(String gaoxiaomingcheng) {
		this.gaoxiaomingcheng = gaoxiaomingcheng;
	}

	public String getPingjunfen() {
		return pingjunfen;
	}

	public void setPingjunfen(String pingjunfen) {
		this.pingjunfen = pingjunfen;
	}

	public String getZuigaofen() {
		return zuigaofen;
	}

	public void setZuigaofen(String zuigaofen) {
		this.zuigaofen = zuigaofen;
	}

	public String getKaoshengdiqu() {
		return kaoshengdiqu;
	}

	public void setKaoshengdiqu(String kaoshengdiqu) {
		this.kaoshengdiqu = kaoshengdiqu;
	}

	public String getKebie() {
		return kebie;
	}

	public void setKebie(String kebie) {
		this.kebie = kebie;
	}

	public String getNianfen() {
		return nianfen;
	}

	public void setNianfen(String nianfen) {
		this.nianfen = nianfen;
	}

	public String getPici() {
		return pici;
	}

	public void setPici(String pici) {
		this.pici = pici;
	}

	public String getZhuanyeduibi() {
		return zhuanyeduibi;
	}

	public void setZhuanyeduibi(String zhuanyeduibi) {
		this.zhuanyeduibi = zhuanyeduibi;
	}

	@Override
	public String toString() {
		return "Gaokao{" +
				"zhuanyemingcheng='" + zhuanyemingcheng + '\'' +
				", gaoxiaomingcheng='" + gaoxiaomingcheng + '\'' +
				", pingjunfen='" + pingjunfen + '\'' +
				", zuigaofen='" + zuigaofen + '\'' +
				", kaoshengdiqu='" + kaoshengdiqu + '\'' +
				", kebie='" + kebie + '\'' +
				", nianfen='" + nianfen + '\'' +
				", pici='" + pici + '\'' +
				", zhuanyeduibi='" + zhuanyeduibi + '\'' +
				'}';
	}
}
