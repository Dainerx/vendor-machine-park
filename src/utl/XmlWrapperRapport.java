package utl;

import models.Rapport;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "rapports")
@XmlAccessorType (XmlAccessType.FIELD)
public class XmlWrapperRapport {
    @XmlElement(name = "rapport")
    private List<Rapport> rapports = null;

	public List<Rapport> getRapports() {
		return rapports;
	}

	public void setRapports(List<Rapport> rapports) {
		this.rapports = rapports;
	}
}
