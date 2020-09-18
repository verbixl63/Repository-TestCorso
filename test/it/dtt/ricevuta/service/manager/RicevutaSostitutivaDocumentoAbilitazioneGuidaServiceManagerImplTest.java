package it.dtt.ricevuta.service.manager;

import it.dtt.ricevuta.bean.DocumentiGuidaBean;
import it.dtt.sicurezza.entity.Utente;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractTransactionalSpringContextTests;

import com.eds.adf.exception.BusinessException;
import com.eds.adf.util.UserMessage;

public class RicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManagerImplTest extends
		AbstractTransactionalSpringContextTests {
	/**
	 * Default logger
	 */
	protected static Log logger = LogFactory
			.getLog(RicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManagerImplTest.class);

	private RicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager ricevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager;


	protected String[] getConfigLocations() {
		return new String[] {
					"classpath*:it/dtt/ricevuta/propertyConfigurer.xml",
					"classpath*:it/dtt/area/common/applicationContext.xml",
					"classpath*:it/dtt/ricevuta/applicationContext.xml",
					"classpath*:it/dtt/sicurezza/applicationContext.xml",
					"classpath*:it/dtt/sicurezza/applicationContext-Model.xml",
					"classpath*:it/dtt/sicurezza/applicationContext-WS.xml",
//					"classpath*:it/dtt/ricevuta/applicationContext-Securing.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/trasportomerci/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/trasportomerci/applicationContext-Model.xml",		
					"classpath*:it/dtt/area/anagrafica/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/area/anagrafica/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/veicolo/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/area/veicolo/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-ModelExt.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-DAOExt.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-ModelExt.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-DAOExt.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-POJO.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-Action.xml"
				};
	}
	
	//la ricerca documento puo' farla solo un'agenzia
	public void testRicercaDocumentoAG() {
		DocumentiGuidaBean documentiGuidaBean = getRicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager().ricercaDocumento(getDocumentiGuidaBean("AP0000200R"), getUtente("AG"));
		assertNotNull(documentiGuidaBean);
	}
	
	public void testRicercaDocumentoAGContattareCed() {
		try {
			getRicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager().ricercaDocumento(getDocumentiGuidaBean("AP0000200"), getUtente("AG"));
		} catch (BusinessException e) {
			assertEquals("message.errore.documento.contattareCed",((UserMessage)e.getUserMessages().get(0)).getMessageKey());
		}
	}

	private DocumentiGuidaBean getDocumentiGuidaBean(String numeroDocumento) {
		DocumentiGuidaBean documentiGuidaBean = new DocumentiGuidaBean();
		documentiGuidaBean.setCognome("TIZIANO");
		GregorianCalendar gc = new GregorianCalendar(1977,9,10);
		Timestamp ts = new Timestamp (gc.getTimeInMillis ());
		documentiGuidaBean.setDataNascita(ts);
		documentiGuidaBean.setCodiceTipoDocumento("P");
		documentiGuidaBean.setNumeroDocumento(numeroDocumento);
		return documentiGuidaBean;
	}


	private Utente getUtente(String type) {
		Utente utente = new Utente();
		if(type.equals("UMC")){
	
		}
		if(type.equals("AG")){
			utente.setProgressivoSedeOperativa("0244");
			utente.setCodiceSiglaProvinciaUtenteEsterno("RM");
		}
		return utente;
	}

	public RicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager getRicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager() {
		return ricevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager;
	}

	public void setRicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager(
				RicevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager ricevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager) {
		this.ricevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager = ricevutaSostitutivaDocumentoAbilitazioneGuidaServiceManager;
	}
	
}
