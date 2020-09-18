/*
 * 
 */
package it.dtt.area.veicolo.validator.tipoveicolo;

import static it.dtt.area.veicolo.validator.tipoveicolo.TipologiaVeicoloConstants.*;

// TODO: Auto-generated Javadoc
/**
 * The Class TipologiaVeicoloUtility.
 */
public class TipologiaVeicoloUtility {

	/**
	 * Verifica formalmente se e' AUTOVEICOLO.
	 *
	 * @param targa the targa
	 * @return true, if is a
	 */
	public final static boolean isA(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere345 = targa.substring(2, 5);
			final String lettere67 = targa.substring(5, 7);
			if (lettere12.matches(ALFABETO_NOT_IOQU) && lettere345.matches(NUMERICO) && lettere67.matches(ALFABETO_NOT_IOQU)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' MOTOVEICOLO.
	 *
	 * @param targa the targa
	 * @return true, if is m
	 */
	public final static boolean isM(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere34567 = targa.substring(2, 7);
			if (lettere12.matches(ALFABETO_NOT_IOQU) && lettere34567.matches(NUMERICO)) {
				if (!TipologiaVeicoloProvincia.isProvincia(lettere12) || TipologiaVeicoloProvincia.isBarlettaTrani(lettere12)) {
					ret = true;
				}
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' RIMOCHIO.
	 *
	 * @param targa the targa
	 * @return true, if is r
	 */

	public final static boolean isR(String targa) {
		return isR_fino_20130220(targa) || isR_dopo_20130220(targa);
	}

	/**
	 * Verifica formalmente se e' RIMOCHIO fino al 2013 febbraio 20.
	 *
	 * @param targa the targa
	 * @return true, if is r fino 20130220
	 */
	public final static boolean isR_fino_20130220(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere34567 = targa.substring(2, 7);
			if (lettere12.matches(ALFABETO_NOT_IOQU) && lettere34567.matches(NUMERICO)) {
				if (!TipologiaVeicoloProvincia.isProvincia(lettere12) || TipologiaVeicoloProvincia.isAgrigento(lettere12)) {
					ret = true;
				}
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' RIMOCHIO dopo al 2013 febbraio 20.
	 *
	 * @param targa the targa
	 * @return true, if is r dopo 20130220
	 */
	public final static boolean isR_dopo_20130220(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere1 = targa.substring(0, 1);
			final String lettere2 = targa.substring(1, 2);
			final String lettere345 = targa.substring(2, 5);
			final String lettere67 = targa.substring(5, 7);
			if (lettere1.equalsIgnoreCase(ALFABETO_X) && lettere2.matches(ALFABETO_NOT_IOQU) && lettere345.matches(NUMERICO) && lettere67.matches(ALFABETO_NOT_IOQU)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' MACCHINA AGRICOLA SEMOVENT or RIMORCHIO
	 * AGRICOLO or MACCHINA AGRICOLA OPERATRICE fino al 2013 febbraio 20.
	 *
	 * @param targa the targa
	 * @return true, if is stv
	 */

	public final static boolean isSTV(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 6) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere345 = targa.substring(2, 5);
			final String lettere6 = targa.substring(5, 6);
			if (lettere12.matches(ALFABETO_NOT_IOQU) && lettere345.matches(NUMERICO) && lettere6.matches(ALFABETO_NOT_IOQU)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' MACCHINA OPERATRICE TRAINATE or MACCHINE
	 * OPERATRICI SEMOVENT.
	 *
	 * @param targa the targa
	 * @return true, if is pn
	 */

	public final static boolean isPN(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 6) {
			targa = targa.trim();
			final String lettere123 = targa.substring(0, 3);
			final String lettere456 = targa.substring(3, 6);
			if (lettere123.matches(ALFABETO) && lettere456.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' CICLOMOTORE.
	 *
	 * @param targa the targa
	 * @return true, if is c
	 */
	public final static boolean isC(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 6) {
			targa = targa.trim();
			final String lettere1 = targa.substring(0, 1);
			if (targa.matches(ALFANUMERICO_CICLOMOTORE) && (lettere1.equalsIgnoreCase(ALFABETO_X) || lettere1.equalsIgnoreCase(ALFABETO_Y))) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato nazionale per
	 * AUTOVEICOLO e RIMORCHIO.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova nazionale E
	 */

	public final static boolean isTargaProvaNazionaleE(String targa) {
		return isTargaProvaNazionaleE_vecchioFormato(targa) || isTargaProvaNazionaleE_nuovoFormato(targa);
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato nazionale per
	 * AUTOVEICOLO e RIMORCHIO di vecchio formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova nazionale E vecchio formato
	 */

	public final static boolean isTargaProvaNazionaleE_vecchioFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 6) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3456 = targa.substring(2, 6);
			if (lettere12.matches(ALFABETO_NOT_IOQU) && !TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere3456.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato nazionale per
	 * AUTOVEICOLO e RIMORCHIO di nuovo formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova nazionale E nuovo formato
	 */
	public final static boolean isTargaProvaNazionaleE_nuovoFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere1 = targa.substring(0, 1);
			final String lettere234567 = targa.substring(1, 7);
			if (lettere1.equalsIgnoreCase(ALFABETO_X) && lettere234567.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato nazionale per
	 * MOTOVEICOLI, MACCHINE AGRICOLE e OPERATRICI.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova nazionale FGH
	 */
	public final static boolean isTargaProvaNazionaleFGH(String targa) {
		return isTargaProvaNazionaleFGH_vecchioFormato(targa) || isTargaProvaNazionaleFGH_nuovoFormato(targa);
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato nazionale per
	 * MOTOVEICOLI, MACCHINE AGRICOLE e OPERATRICI di vecchio formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova nazionale FG H vecchio formato
	 */
	public final static boolean isTargaProvaNazionaleFGH_vecchioFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 5) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere345 = targa.substring(2, 5);
			if (lettere12.matches(ALFABETO_NOT_IOQU) && !TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere345.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato nazionale per
	 * MOTOVEICOLI, MACCHINE AGRICOLE e OPERATRICI di nuovo formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova nazionale FG H nuovo formato
	 */

	public final static boolean isTargaProvaNazionaleFGH_nuovoFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere1 = targa.substring(0, 1);
			final String lettere234567 = targa.substring(1, 7);
			if (lettere1.equalsIgnoreCase(ALFABETO_X) && lettere234567.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per
	 * AUTOVEICOLO, MOTOVEICOLO, RIMORCHIO, MACCHINE AGRICOLE SEMOVENTI RIMORCHI
	 * AGRICOLI e MACCHINE AGRICOLE OPERATRICI.
	 *
	 * @param targa the targa
	 * @return true, if is targa provinciale AMRSTV
	 */

	public final static boolean isTargaProvincialeAMRSTV(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 8) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3 = targa.substring(2, 3);
			final String lettere45 = targa.substring(3, 5);
			final String lettere67 = targa.substring(5, 7);
			final String lettere8 = targa.substring(7, 8);
			final String lettere345678 = targa.substring(2, 8);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && TipologiaVeicoloProvincia.isProvinciaAMRSTV(lettere12) && lettere3.matches(ALFANUMERICO_NOT_CIJOQ) && lettere45.matches(ALFANUMERICO_NOT_BCIJOQ) && lettere67.matches(NUMERICO) && lettere8.matches(ALFANUMERICO_NOT_BCIJKOQU) && lettere345678.matches(ALFABETO_PRESENTE_ALMENO_UNO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per
	 * Macchine Operatrici Semoventi.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova provinciale P
	 */

	public final static boolean isTargaProvaProvincialeP(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere34 = targa.substring(2, 4);
			final String lettere567 = targa.substring(4, 7);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere34.matches(ALFABETO) && lettere567.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per
	 * MACCHINE OPERATRICI TRAINATE.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova provinciale N
	 */

	public final static boolean isTargaProvaProvincialeN(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3 = targa.substring(2, 3);
			final String lettere4567 = targa.substring(3, 7);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere3.matches(ALFABETO) && lettere4567.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per 4.3
	 * MACCHINE AGRICOLE OPERATRICI SEMOVENTI AD UN ASSE, MACCHINE AGRICOLE
	 * OPERATRICI TRAINATE, RIMORCHI AGRICOLI di massa complessiva a pieno
	 * carico non superiore a 1,5 t, di lunghezza non superiore a 4m e di
	 * larghezza non superiore a 2 m
	 *
	 * @param targa the targa
	 * @return true, if is targa prova provinciale UXY
	 */

	public final static boolean isTargaProvaProvincialeUXY(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3 = targa.substring(2, 3);
			final String lettere456 = targa.substring(3, 6);
			final String lettere7 = targa.substring(6, 7);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere3.matches(ALFABETO) && lettere456.matches(NUMERICO) && lettere7.matches(ALFABETO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per
	 * Macchine Operatrici Non Circolanti.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova provinciale Z
	 */

	public final static boolean isTargaProvaProvincialeZ(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere34567 = targa.substring(3, 7);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere34567.matches(NUMERICO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per TIPO
	 * VEICOLO <E> (AUTOVEICOLO E RIMORCHIO).
	 *
	 * @param targa the targa
	 * @return true, if is targa prova provinciale E
	 */

	public final static boolean isTargaProvaProvincialeE(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 6) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3 = targa.substring(2, 3);
			final String lettere45 = targa.substring(3, 5);
			final String lettere6 = targa.substring(5, 6);
			final String lettere3456 = targa.substring(2, 6);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere3.matches(ALFANUMERICO_NOT_CIJOQ) && lettere45.matches(ALFANUMERICO_NOT_BCIJOQ) && lettere6.matches(ALFANUMERICO_NOT_BCIJKOQU) && lettere3456.matches(ALFABETO_PRESENTE_ALMENO_UNO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per TIPO
	 * VEICOLO <F> (MOTOVEICOLO).
	 *
	 * @param targa the targa
	 * @return true, if is targa prova provinciale F
	 */

	public final static boolean isTargaProvaProvincialeF(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 6) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3456 = targa.substring(2, 6);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere3456.matches(ALFANUMERICO) && lettere3456.matches(ALFABETO_PRESENTE_ALMENO_UNO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato provinciale per
	 * MACCHINE AGRICOLE e OPERATRICI.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova provinciale GH
	 */

	public final static boolean isTargaProvaProvincialeGH(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 5) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3 = targa.substring(2, 3);
			final String lettere45 = targa.substring(3, 5);
			final String lettere345 = targa.substring(2, 5);
			if (TipologiaVeicoloProvincia.isProvincia(lettere12) && lettere3.matches(ALFANUMERICO_NOT_CIJOQ) && lettere45.matches(ALFANUMERICO_NOT_BCIJOQ) && lettere345.matches(ALFABETO_PRESENTE_ALMENO_UNO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa di prova in formato personalizzata per
	 * AUTOVEICOLO e RIMORCHIO, MOTOVEICOLO, MACCHINE AGRICOLE, MACCHINE
	 * OPERATRICI.
	 *
	 * @param targa the targa
	 * @return true, if is targa prova personalizzata EFGH
	 */

	public final static boolean isTargaProvaPersonalizzataEFGH(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			if (targa.matches(ALFANUMERICO_NOT_IOQU)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa corpo diplomatico.
	 *
	 * @param targa the targa
	 * @return true, if is targa corpo diplomatico
	 */

	public final static boolean isTargaCorpoDiplomatico(String targa) {
		return isTargaCorpoDiplomatico_vecchioFormato(targa) || isTargaCorpoDiplomatico_nuovoFormato(targa);
	}

	/**
	 * Verifica formalmente se e' targa corpo diplomatico in vecchio formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa corpo diplomatico vecchio formato
	 */

	public final static boolean isTargaCorpoDiplomatico_vecchioFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere345 = targa.substring(2, 5);
			final String lettere67 = targa.substring(5, 7);
			if (lettere12.equalsIgnoreCase(ALFABETO_CD) && lettere345.matches(NUMERICO) && lettere67.matches(ALFABETO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa corpo diplomatico in nuovo formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa corpo diplomatico nuovo formato
	 */

	public final static boolean isTargaCorpoDiplomatico_nuovoFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 8) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3456 = targa.substring(2, 6);
			final String lettere78 = targa.substring(6, 8);
			if (lettere12.equalsIgnoreCase(ALFABETO_CD) && lettere3456.matches(NUMERICO) && lettere78.matches(ALFABETO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa corpo consolare.
	 *
	 * @param targa the targa
	 * @return true, if is targa corpo consolare
	 */

	public final static boolean isTargaCorpoConsolare(String targa) {
		return isTargaCorpoConsolare_vecchioFormato(targa) || isTargaCorpoConsolare_nuovoFormato(targa);
	}

	/**
	 * Verifica formalmente se e' targa corpo consolare in vecchio formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa corpo consolare vecchio formato
	 */

	public final static boolean isTargaCorpoConsolare_vecchioFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere345 = targa.substring(2, 5);
			final String lettere67 = targa.substring(5, 7);
			if (lettere12.equalsIgnoreCase(ALFABETO_CC) && lettere345.matches(NUMERICO) && lettere67.matches(ALFABETO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * Verifica formalmente se e' targa corpo consolare in nuovo formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa corpo consolare nuovo formato
	 */
	public final static boolean isTargaCorpoConsolare_nuovoFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 8) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere3456 = targa.substring(2, 6);
			final String lettere78 = targa.substring(6, 8);
			if (lettere12.equalsIgnoreCase(ALFABETO_CD) && lettere3456.matches(NUMERICO) && lettere78.matches(ALFABETO)) {
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * Verifica formalmente se e' targa escursionisti esteri.
	 *
	 * @param targa the targa
	 * @return true, if is targa escursionista estera
	 */
	public final static boolean isTargaEscursionistaEstera(String targa) {
		return isTargaEscursionistaEstera_vecchioFormato(targa) || isTargaEscursionistaEstera_nuovoFormato(targa);
	}
	
	/**
	 * Verifica formalmente se e' targa escursionisti esteri in vecchio formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa escursionista estera vecchio formato
	 */
	public final static boolean isTargaEscursionistaEstera_vecchioFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 6) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere345 = targa.substring(2, 5);
			final String lettere6 = targa.substring(5, 6);
			if (lettere12.equalsIgnoreCase(ALFABETO_EE) && lettere345.matches(NUMERICO) && lettere6.matches(ALFABETO)) {
				ret = true;
			}
		}
		return ret;
	}
	
	/**
	 * Verifica formalmente se e' targa escursionisti esteri in nuovo formato.
	 *
	 * @param targa the targa
	 * @return true, if is targa escursionista estera nuovo formato
	 */
	public final static boolean isTargaEscursionistaEstera_nuovoFormato(String targa) {
		boolean ret = false;
		if (targa != null && targa.trim().length() == 7) {
			targa = targa.trim();
			final String lettere12 = targa.substring(0, 2);
			final String lettere345 = targa.substring(2, 5);
			final String lettere67 = targa.substring(6, 7);
			if (lettere12.equalsIgnoreCase(ALFABETO_EE) && lettere345.matches(NUMERICO) && lettere67.matches(ALFABETO)) {
				ret = true;
			}
		}
		return ret;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// AUTOVEICOLO
		System.out.println(isA("AZ113AD"));
		// MOTOVEICOLO
		System.out.println(isM("BT11319"));
		// RIMORCHIO
		System.out.println(isR("XQ113AD"));
		// STV
		System.out.println(isSTV("XQ113AD"));
		// PN
		System.out.println(isPN("XQ113AD"));

		System.out.println(isTargaProvaProvincialeP("RMaq111"));

	}

}
