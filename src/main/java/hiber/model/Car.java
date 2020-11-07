package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@OneToOne(mappedBy = "car")
	private User user;

	@Column(name = "model")
	private String model;

	@Column(name = "series")
	private int series;

	public Car() {
	}

	public Car(String model, int series) {
		this.model = model;
		this.series = series;
	}

	public String getModel() {
		return model;
	}

	public int getSeries() {
		return series;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setSeries(int series) {
		this.series = series;
	}

	@Override
	public String toString() {
		return getModel() + " " + getSeries();
	}
}
