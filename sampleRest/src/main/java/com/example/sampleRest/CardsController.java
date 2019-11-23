package com.example.sampleRest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class CardsController {
	@Autowired
	  private CardRepository cardRepository;
	
	/**
	 * Get key value againt PAN
	 * @param PAN PAN 
	 * @return KeyValue the key value of PAN
	 * 
	 */
	@GetMapping("/cards/{PAN}")
	public static String getKeyValue(@PathVariable(value = "PAN") Long PAN) {
		/*Card card =
	    		cardRepository
	            .findById(PAN)
	            .orElseThrow(() -> new Exception("card not found on :: " + cardId));
	     ResponseEntity.ok().body(card);*/
		return "843ae129478b2e";
	}
	
	/**
	   * Get all cards list.
	   *
	   * @return the list
	   */
	  @GetMapping("/cards")
	  public List<Card> getAllCards() {
		  System.out.println("Inside get all ");
	    return cardRepository.findAll();
	  }
	  
	  /**
	   * Gets cards by id.
	   *
	   * @param cardId the card id
	   * @return the card by id
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	  @GetMapping("/cards/{id}")
	  public ResponseEntity<Card> getCardsById(@PathVariable(value = "id") Long cardId)
	      throws Exception {
	    Card card =
	    		cardRepository
	            .findById(cardId)
	            .orElseThrow(() -> new Exception("card not found on :: " + cardId));
	    return ResponseEntity.ok().body(card);
	  }
	  
	  /**
	   * Create card card.
	   *
	   * @param card the card
	   * @return the card
	   */
	  @PostMapping("/cards")
	  public Card createCards(@Valid @RequestBody Card card) {
	    return cardRepository.save(card);
	  }
	  
	  /**
	   * Update card response entity.
	   *
	   * @param cardId the card id
	   * @param cardDetails the card details
	   * @return the response entity
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	  @PutMapping("/cards/{id}")
	  public ResponseEntity<Card> updateCard(
	      @PathVariable(value = "id") Long cardId, @Valid @RequestBody Card cardDetails)
	      throws Exception {
	    Card card =
	        cardRepository
	            .findById(cardId)
	            .orElseThrow(() -> new Exception("Card not found on :: " + cardId));
	   /// TODO :
	    card.setPAN(cardDetails.getPAN());
	    card.setKey(cardDetails.getKey());
	    final Card updatedCard = cardRepository.save(card);
	    return ResponseEntity.ok(updatedCard);
	  }
	  
}



  
 