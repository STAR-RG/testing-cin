// This file is part of the 'texasholdem' project, an open source
// Texas Hold'em poker application written in Java.
//
// Copyright 2009 Oscar Stigter
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package ex4;

import org.junit.Test;
import org.ozsoft.texasholdem.Card;

/**
 * Test suite for the Card class.
 * 
 * @author Oscar Stigter
 */
public class CardTest {
    
    /**
     * Tests the constructors (bad-weather).
     */
	
	@Test(expected=IllegalArgumentException.class)
    public void testNumericRankTooLow() {
        @SuppressWarnings("unused")
		Card card = new Card(-1, 0);
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void testEmptyString() {
		@SuppressWarnings("unused")
		Card card = new Card("");
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void testStringTooShort() {
        @SuppressWarnings("unused")
		Card card = new Card("A");
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void testStringTooLong() {
        @SuppressWarnings("unused")
		Card card = new Card("Ahx");		
	}
	
}
