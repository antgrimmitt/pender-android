/**
 * Copyright 2012 Adobe Systems Incorporated
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.pender;

import java.util.ArrayList;

import android.opengl.GLES10;

import com.pender.glaid.Image;
import com.pender.glaid.Polygon;



public class PenderCanvas {
	
	public PenderCanvas( PenderRenderer renderer ) {
		
		float vert[] = { /*
				 0.0f, 100.0f, 0.0f,
				 0.0f, 0.0f, 0.0f,
				 100.0f, 0.0f, 0.0f,
				 100.0f, 100.0f, 0.0f,
				*/
	  		      -1.0f,  1.0f, 0.0f,
	  		      -1.0f, -1.0f, 0.0f,
	  		       1.0f, -1.0f, 0.0f,
	  		       1.0f,  1.0f, 0.0f,
	  		       
	  	};

	  	short[] ind = { 0, 1, 2, 0, 2, 3 };

		mPoly = new Polygon( vert, ind );
		
		mRenderer = renderer;
		
		mImageList = new ArrayList<Image>();
		
		
		
	}

    public void drawImage( int image, float dx, float dy) {
 
        mRenderer.drawTexturedPolygon(mPoly, mImageList.get(image) );
    	 
    } 
    
    /**
     * 
     * @param image integer reference to the image
     * @param dx x coordinate of top right corner 
     * @param dy y coordinate of top right corner
     * @param dw image width
     * @param dh image height
     */
    public void drawImage( int image, float dx, float dy, float dw, float dh){

    }

    public void drawImage( int  image, float sx, float sy, float sw, float sh, 
                                       float dx, float dy, float dw, float dh) {

    }
    
    //==========================================================================
    //==========================================================================
    
    public void scale( float x, float y ) {
    	
    	//awesome
    	GLES10.glScalef(x, y, 0.0f);
    	
    }
    
    public void rotate( float angle ) {
    	
    	//this is problematic, and will require some creativity
    	//for now the center of rotation will always be about the origin
    	GLES10.glRotatef( angle , 0.0f, 0.0f, 0.0f);
    	
    }
    
    public void translate( float x, float y ) {
    	
        //awesome
        GLES10.glTranslatef( x, y, 0.0f );
    	
    }

	
    @SuppressWarnings("unchecked")
	public void setImageList( ArrayList<Image> imagelist ) {
    	mImageList = (ArrayList<Image>) imagelist.clone();
    }
    private ArrayList<Image> mImageList;
    
    Polygon mPoly;
    
    PenderRenderer mRenderer;
    
}