import React from "react";
// import Swiper core and required modules
import { Navigation, Pagination, A11y } from 'swiper/modules';
import { Swiper, SwiperSlide } from 'swiper/react';
// Import Swiper styles

const ImgSlider = () => {
    const imgSize = () => {
        return {
            width: '650px',
            height: '1350px',
            objectFit: 'cover'
        };
    };

    return (
        <>
            <Swiper
                modules={[Navigation, Pagination, A11y]}
                spaceBetween={0}
                slidesPerView={1}
                navigation
                pagination={{ clickable: true }}
                // onSwiper={(swiper) => console.log(swiper)}
                // onSlideChange={() => console.log('slide change')}
            >
                <SwiperSlide><img src="/" style={imgSize()} /></SwiperSlide>
                <SwiperSlide><img src="/" style={imgSize()} /></SwiperSlide>
                <SwiperSlide><img src="/" style={imgSize()} /></SwiperSlide>
            </Swiper>
        </>
    )
}

export default ImgSlider