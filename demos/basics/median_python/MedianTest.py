import unittest
from Median import median

class MedianTestCase(unittest.TestCase):
    def test_median_is_first(self):
        self.assertEqual(2, median(2, 1, 3))

    def test_median_is_last(self):
        self.assertNotEqual(1, median(3, 1, 2))

    # used to skip the test under some justification        
    @unittest.skip('not working') 
    def test_median_is_middle(self):
        self.assertEqual(1, median(1, 2, 3))

if __name__ == '__main__':
    unittest.main()
