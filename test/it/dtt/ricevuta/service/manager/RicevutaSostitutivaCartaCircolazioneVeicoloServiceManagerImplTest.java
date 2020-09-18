package it.dtt.ricevuta.service.manager;

import it.dtt.ricevuta.bean.DocumentoCircolazioneBean;
import it.dtt.sicurezza.entity.Utente;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractTransactionalSpringContextTests;

public class RicevutaSostitutivaCartaCircolazioneVeicoloServiceManagerImplTest extends
		AbstractTransactionalSpringContextTests {
	/**
	 * Default logger - modifica del 18.09.2020
	 */
	protected static Log logger = LogFactory
			.getLog(RicevutaSostitutivaCartaCircolazioneVeicoloServiceManagerImplTest.class);

	private RicevutaSostitutivaCartaCircolazioneVeicoloServiceManager ricevutaSostitutivaCartaCircolazioneVeicoloServiceManager;

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


	public RicevutaSostitutivaCartaCircolazioneVeicoloServiceManager getRicevutaSostitutivaCartaCircolazioneVeicoloServiceManager() {
		return ricevutaSostitutivaCartaCircolazioneVeicoloServiceManager;
	}


	public void setRicevutaSostitutivaCartaCircolazioneVeicoloServiceManager(
				RicevutaSostitutivaCartaCircolazioneVeicoloServiceManager ricevutaSostitutivaCartaCircolazioneVeicoloServiceManager) {
		this.ricevutaSostitutivaCartaCircolazioneVeicoloServiceManager = ricevutaSostitutivaCartaCircolazioneVeicoloServiceManager;
	}


	public void testRicercaDocumentoAnnoImmatricolazioneNull() {
		DocumentoCircolazioneBean documentoCircolazioneBean = ricevutaSostitutivaCartaCircolazioneVeicoloServiceManager.ricercaDocumento(getDocumentoCircolazioneBean("VF320CK2203354242","AG299035"), getUtente("AG"));
		assertNotNull("documentoCircolazioneBean null",documentoCircolazioneBean);
		assertEquals("PROPRIO", documentoCircolazioneBean.getUso());
		assertNull("AnnoImmatricolazione diverso da null",documentoCircolazioneBean.getAnnoImmatricolazione());
		assertEquals("AnnoImmatricolazioneVeicolo diverso da 0",0, documentoCircolazioneBean.getAnnoImmatricolazioneVeicolo());
	}
	
	public void testRicercaDocumento() {
		DocumentoCircolazioneBean documentoCircolazioneBean = ricevutaSostitutivaCartaCircolazioneVeicoloServiceManager.ricercaDocumento(getDocumentoCircolazioneBean("SEAGT744343333332","RM4F6574"), getUtente("AG"));
		assertNotNull("documentoCircolazioneBean null",documentoCircolazioneBean);
		assertEquals("PROPRIO", documentoCircolazioneBean.getUso());
		assertNotNull("AnnoImmatricolazione null",documentoCircolazioneBean.getAnnoImmatricolazione());
		assertNotSame("AnnoImmatricolazioneVeicolo 0",0, documentoCircolazioneBean.getAnnoImmatricolazioneVeicolo());
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


	private DocumentoCircolazioneBean getDocumentoCircolazioneBean(String telaio,String targa) {
		DocumentoCircolazioneBean documentoCircolazioneBean = new DocumentoCircolazioneBean();
		documentoCircolazioneBean.setCodiceTipoVeicolo("A");
		documentoCircolazioneBean.setCodiceTipoDocumentoRichiesto("V");
		documentoCircolazioneBean.setTelaio(telaio);
		documentoCircolazioneBean.setIdVeicolo(targa);
		return documentoCircolazioneBean;
	}

}
